
window.onload = () => sensorData();

function sensorData() {
     fetch('http://localhost:8081/api/sensor-observation')
        .then(res => res.json())
        .then(function(data) {
                document.getElementById("temperature").innerHTML = data.temperature,
                document.getElementById("gyroscope").innerHTML = data.gyroscope,
                document.getElementById("accelerometer").innerHTML = data.accelerometer,
                document.getElementById("magnetometer").innerHTML = data.magnetometer,
                document.getElementById("pressure").innerHTML = data.pressure,
                document.getElementById("humidity").innerHTML = data.humidity
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


/*window.setInterval(function(){
    sensorData()
}, 5000);*/

