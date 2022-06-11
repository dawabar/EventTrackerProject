window.addEventListener('load', function(e) {
	console.log('script.js loaded');
	init();
	e.preventDefault();
});

function init() {
	console.log('In init');
	loadChoresList();
}

function loadChoresList() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/chores');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let chores = JSON.parse(xhr.responseText);
				displayChoresList(chores);
			}
			else {
				//TODO: show errors.
			}
		}
	};

	xhr.send();
}

function displayChoresList(chores) {
	let tbody = document.getElementById('choresTableRows');
	tbody.textContent = '';
	for (let chore of chores) {
		let trow = document.createElement('tr');
		trow.addEventListener('click', function(e) {
			displayChore(chore);
		});
		let td = document.createElement('td');
		td.textContent = chore.id;
		td.onclick = 'viewEntries';
		td.align = 'right';
		trow.appendChild(td);
		td = document.createElement('td');
		td.textContent = chore.name;
		trow.appendChild(td);
		td = document.createElement('td');
		td.textContent = '$' + chore.price;
		trow.appendChild(td);
		tbody.appendChild(trow);
	}
}

function displayChore(chore) {
	console.log(chore.name);
	let choreDiv = document.getElementById('chore');
	choreDiv.textContent = chore.name;
}

function displayAddChoreForm(e) {
	e.preventDefault();
	console.log('In the displayAddChoreForm function')
	let newChoreForm = document.getElementById('newChoreForm');
	if (newChoreForm.style.display === 'none') {
		newChoreForm.addClass('newChoreForm');
	}
	else {
		newChoreForm.removeClass('newChoreForm');
	}
}

/* function showSeriesDetails(e) {
	e.preventDefault();
	let row = e.target;
	console.log(row);
	let seriesId = row.parentElement.firstElementChild.textContent;
	console.log(seriesId.name);
} */