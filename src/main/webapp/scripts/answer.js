function setR(n) {
    for (let i=0; i < 2; i++) {
        document.querySelectorAll("#R")[i].textContent = n.toString()
        document.querySelectorAll("#R2")[i].textContent = (n / 2).toString()
        document.querySelectorAll("#mR")[i].textContent = (-n).toString()
        document.querySelectorAll("#mR2")[i].textContent = (-n / 2).toString()
    }
}
let r = Number(document.querySelector("#r_ans").textContent)
setR(r)

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
    location.href = "./control?x=" + svgPoint.x + "&y=" + svgPoint.y + "&r=" + r
});
