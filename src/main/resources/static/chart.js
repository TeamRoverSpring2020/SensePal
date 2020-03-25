






let myChart = document.getElementById('MyChart').getContext('2d');
// Global options


// Chart.defaults.global.defaultFontColor = '#777';
let chart = new Chart(myChart, {
    type: 'line', // bar,orizontalbar, pie,line,doughnut
    data:{
        labels:['15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00', '24:00', '01:00'],
        datasets:[{
            label: 'Temperature',
            data:[
                35,
                34,
                32,
                22,
                24,
                25,
                28,
                30,
                35,
                32,
                30
            ],
            backgroundColor: '#84a1b3',
            borderWidth:1,
            borderColor:'grey'
        },{
            label: 'Humidity',
            data:[
                37,
                38,
                39,
                35,
                43,
                35,
                31,
                30,
                35,
                32,
                30
            ],
            backgroundColor: '#c7d3dc',
            borderWidth:1,
            borderColor:'grey'
        }]
    },
    options:{
        title:{
            display:true,
            text: 'SenseGraph',
            fontSize: 20,
            marginBottom: 20,
        },
        legend:{
            position: 'bottom',
            padding: 20,
            labels: {
                fontColor: 'black'
            }
        }
    }
});