document.querySelectorAll('#calculate_form input[type="checkbox"]')
    .forEach(box => {
    box.addEventListener('change', function() {
        if (this.checked) {
            // Снимаем выделение с других checkbox в той же группе
            document.querySelectorAll('#calculate_form input[type="checkbox"]')
                .forEach(other => {
                if (other !== this) other.checked = false;
            });
        } else {
            this.checked = true
        }
    });
});

let r = 2
function setR(n) {
    r = n
    for (let i=0; i < 2; i++) {
        document.querySelectorAll("#R")[i].textContent = n.toString()
        document.querySelectorAll("#R2")[i].textContent = (n / 2).toString()
        document.querySelectorAll("#mR")[i].textContent = (-n).toString()
        document.querySelectorAll("#mR2")[i].textContent = (-n / 2).toString()
    }
    document.querySelectorAll(".point").forEach(p => {
        p.style.display = 'none'
    })
    document.querySelectorAll(".point.r" + (Math.round(n*10))).forEach(p => {
        p.style.display = 'inline-block'
    })
}

document.querySelectorAll('#calculate_form input[name="r"]')
    .forEach(r_checkbox => {
    r_checkbox.addEventListener('change', () => {
        if (r_checkbox.checked) {
            setR(r_checkbox.value);
        }
    })
    if (r_checkbox.checked) {
        setR(r_checkbox.value);
    }
})

svg = document.querySelector("svg")
svg.addEventListener('click', (event) => {
    // Получаем SVG-элемент
    const svg = event.target;

    // Создаем точку в SVG-координатах
    const point = new DOMPoint();

    // Устанавливаем координаты мыши (относительно viewport)
    point.x = event.clientX;
    point.y = event.clientY;

    const svgPoint = point.matrixTransform(svg.getScreenCTM().inverse());

    svgPoint.x = (svgPoint.x-250) / 120 * r
    svgPoint.y = (250-svgPoint.y) / 120 * r
    console.log(`X: ${svgPoint.x}, Y: ${svgPoint.y}`);
    if (-4 <= svgPoint.x && svgPoint.x <= 4) {
        if (-5 <= svgPoint.y && svgPoint.y <= 3) {
            location.href = ".?x=" + svgPoint.x + "&y=" + svgPoint.y + "&r=" + r
        } else {
            document.querySelector('#calculate_form input[name="y"]').setCustomValidity("y не в [-5,3]")
            document.querySelector('#calculate_form input[name="y"]').reportValidity()
        }
    } else {
        document.querySelector('#calculate_form input[name="x"]:checked').setCustomValidity("x не в [-4,4]")
        document.querySelector('#calculate_form input[name="x"]:checked').reportValidity()
    }
});
