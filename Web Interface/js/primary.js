function init() {
	loadNavBar();
}

function loadNavBar() {
	if (!supportsImports())
		$("#navbar_space").load("navbar.html"); 
}

function supportsImports() {
  return 'import' in document.createElement('link');
}