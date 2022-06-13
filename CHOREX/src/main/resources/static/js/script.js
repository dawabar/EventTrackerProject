window.addEventListener('load', function(e) {
	console.log('script.js loaded');
	init();
	//	e.preventDefault();
});

function init() {
	console.log('In init');
	loadChoresList();
	document.updateChoreForm.updateChoreButton.addEventListener('click', updateChore);
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
	let updateChoreId = document.getElementById('updateChoreId');
	updateChoreId.value = chore.id;
	updateChoreId.disabled = true;
	let updateChoreName = document.getElementById('updateChoreName');
	updateChoreName.value = chore.name;
	let updateChorePrice = document.getElementById('updateChorePrice');
	updateChorePrice.value = chore.price;
}

function updateChore(e) {
	e.preventDefault();
	let form = document.updateChoreForm;
	let changedChore = {
		id: form.updateChoreId.value,
		name: form.updateChoreName.value,
		price: form.updateChorePrice.value
	};
	console.log(changedChore);
	sendUpdatedChore(changedChore);
}

function sendUpdatedChore(chore) {
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', `api/chores/${chore.id}`);
	xhr.onreadystatechange = function() {
		if (xhr.status === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let chore = JSON.parse(xhr.responseTest);
				console.log(chore);
			}
			else {
				displayError('Error creating series: ' + xhr.status + " " + xhr.statusText);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(chore));
	
	init();	

}


/*
function displayChore(chore) {
	console.log(chore.name);
	let choreDiv = document.getElementById('chore');
	let h3 = document.createElement('h3');
	let br = document.createElement('br');
	let td = document.createElement('td');
	let table = document.createElement('table'); 
	let thead = document.createElement('thead');
	table.appendChild(thead);
	let th = document.createElement('th');
	for (let property in chore) {
		if (chore.hasOwnProperty(property)) {
			th.textContent = property;
			thead.appendChild(th);
		}
	}
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);
	let tr = document.createElement('tr');
	for (let property in chore) {
		if (chore.hasOwnProperty(property)) {
			for (val in property) {
				td.textContent = property.val;
				tr.appendChild(td);
			}
		}
	}
	choreDiv.appendChild('table');

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
*/

/* function showSeriesDetails(e) {
	e.preventDefault();
	let row = e.target;
	console.log(row);
	let seriesId = row.parentElement.firstElementChild.textContent;
	console.log(seriesId.name);
} */