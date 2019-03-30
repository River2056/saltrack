const time = document.querySelector(".time");
const currentDate = document.getElementById("currentDate");
let date = new Date();
let year = date.getFullYear();
let month = date.getMonth() + 1;
let day = date.getDate();
if (month < 10) {
	month = '0' + month;
}

let dateToString = `${year}-${month}-${day}`;
currentDate.value = dateToString;

function now() {
	date = new Date();
	time.innerHTML = date;
}




setInterval(now, 100);







