
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

function getMessage(){
    document.getElementById("temperature").innerHTML = "det gikk!";
}

function controlBoard(direction) {
    const options = {
        method: "POST",
        body: JSON.stringify({direction: direction}),
        headers: new Headers({
            "Content-Type": "application/json"
        })
    }

    fetch('http://localhost:8081/api/navigation', options)
        .then(response => console.log(response));
}


/*window.setInterval(function(){
    sensorData()
}, 5000);*/

