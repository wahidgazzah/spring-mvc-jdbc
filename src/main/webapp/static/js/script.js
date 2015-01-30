function switchDetails(userId){
	document.getElementById("deleteAction").setAttribute("href", "../../delete?id=" + userId);
	document.getElementById("device-details").style.display = "block";
}

function closeDetails(){
	document.getElementById("device-details").style.display = "none";
}