var ctx = document.getElementById('exampleChart').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: 'lightblue',
            borderColor: 'rgb(255, 99, 132)',
            data: [1, 15, 3, 45, 20, 85]
        }]
    },

    // Configuration options go here
    options: {
        responsive: true,
        legend: {
            labels: {
            }
        }
    }
});
// Chart.defaults.global.defaultFontColor = 'white';
// Chart.defaults.global.defaultFontSize= 20;