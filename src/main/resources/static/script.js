
window.onload = () => sensorData();

function sensorData() {
     fetch('/api/sensor-observation')
        .then(res => res.json())
        .then(function(data) {
                document.getElementById("temperature").innerHTML = data.temperature + " C",
                document.getElementById("pressure").innerHTML = data.pressure + " mBar",
                document.getElementById("humidity").innerHTML = data.humidity + " %"
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




