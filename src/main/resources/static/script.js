
window.onload = () => sensorData();
document.onkeydown = checkKey;


function sensorData() {
     fetch('/api/sensor-observation')
        .then(res => res.json())
        .then(function(data) {
                document.getElementById("timestamp").innerHTML = data.timestamp,
                document.getElementById("temperature").innerHTML = (Math.round(data.temperature * 100) / 100) + " C",
                document.getElementById("pressure").innerHTML = (Math.round(data.pressure * 100) / 100) + " mBar",
                document.getElementById("humidity").innerHTML = (Math.round(data.humidity * 100) / 100) + " %"
        });
}

function controlBoard(dir) {
    const options = {
        method: "POST",
        credentials: "include",
        body: JSON.stringify({
            direction: dir
        }),
        headers: new Headers({
            "Content-Type": "application/json",
        })
    }

    fetch('/api/navigation', options)
        .then(response => console.log(response));
}


window.setInterval(function(){
    sensorData()
}, 3000);


function checkKey(e) {

    e = e || window.event;

    if (e.keyCode == '38') {
        controlBoard('drive')
    }
    else if (e.keyCode == '40') {
        controlBoard('reverse')
    }
    else if (e.keyCode == '37') {
        controlBoard('left')
    }
    else if (e.keyCode == '39') {
        controlBoard('right')
    }
    else if (e.keyCode == '32') {
        controlBoard('stop')
    }
}





