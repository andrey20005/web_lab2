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

function setR(n) {
    for (let i=0; i < 2; i++) {
        document.querySelectorAll("#R")[i].textContent = n.toString()
        document.querySelectorAll("#R2")[i].textContent = (n / 2).toString()
        document.querySelectorAll("#mR")[i].textContent = (-n).toString()
        document.querySelectorAll("#mR2")[i].textContent = (-n / 2).toString()
    }
}

document.querySelectorAll('#calculate_form input[name="R"]')
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
