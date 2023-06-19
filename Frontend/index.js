// Call the API endpoint
// fetch('http://localhost:8088/sprints',{
//     mode: 'cors'
// })
// .then(response => {
//   // Check if the response was successful
//   if (!response.ok) {
//     throw new Error('Network response was not ok');
//   }
//   return response.json();
// })
// .then(data => {
//   // Display the API response on the web page
//   const output = document.getElementById('output');
//   output.textContent = JSON.stringify(data);
// })
// .catch(error => {
//   // Display any errors on the web page
//   const output = document.getElementById('output');
//   output.textContent = 'Error: ' + error.message;
// });