window.onload = function(){
	var popup = document.getElementById('overlayChangePlayers');
    var overlay = document.getElementById('backgroundOverlay');
    var openButton = document.getElementById('player-imagen');
    document.onclick = function(e){
        if(e.target.id == 'backgroundOverlay'){
            popup.style.display = 'none';
            overlay.style.display = 'none';
        }
        if(e.target === openButton ){
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
		if(e.target === popup ){
         	popup.style.display = 'none';
            overlay.style.display = 'none';
        }
	}
}