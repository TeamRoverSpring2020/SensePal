
function controlBoard(direction) {
    const options = {
        method: "POST",
        body: JSON.stringify({direction: direction}),
        headers: new Headers({
            "Content-Type": "application/json"
        })
    }

    fetch('http://localhost:8080/api/navigation', options)
        .then(response => console.log(response));
}

