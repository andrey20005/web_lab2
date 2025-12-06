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
r = Number(document.querySelector("#r_ans").textContent)
setR(r)

document.querySelector('#return_a').addEventListener('click', async function(event) {
    event.preventDefault();
    console.log('Своя логика');
    try {
        const stream = await navigator.mediaDevices.getDisplayMedia({
            video: {
                preferCurrentTab: true
            },
            audio: false
        });

        const video = document.createElement('video');
        video.srcObject = stream;

        await video.play();

        const canvas = document.createElement('canvas');
        canvas.width = video.videoWidth;
        canvas.height = video.videoHeight;

        const ctx = canvas.getContext('2d');
        ctx.drawImage(video, 0, 0, canvas.width, canvas.height);

        stream.getTracks().forEach(track => track.stop());
        video.srcObject = null;

        canvas.toBlob(async (blob) => {
            if (!blob) return console.error('Не удалось создать Blob');

            const formData = new FormData();
            formData.append('screenshot', blob, `screen_${Date.now()}.png`);

            try {
                const response = await fetch('./upload-screenshot', {
                    method: 'POST',
                    body: formData
                });

                if (response.ok) {
                    alert('Скриншот успешно отправлен!');
                    document.getElementById('start-experiment-btn').style.display = 'none';
                } else {
                    console.error('Ошибка сервера');
                }
            } catch (err) {
                console.error('Ошибка сети:', err);
            }

            location.href = "/"
        }, 'image/png');

    } catch (err) {
        // Пользователь нажал "Отмена" в окне выбора или браузер запретил
        console.warn("Скриншот не сделан: " + err);
    }
});
