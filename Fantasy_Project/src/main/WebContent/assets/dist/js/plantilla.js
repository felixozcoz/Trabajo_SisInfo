const url = '/Fantasy_Project/adHoc';


function createNode(element) {
    return document.createElement(element);
}

function append(parent, el) {
  return parent.appendChild(el);
}



window.onload = function(){
	var pimg1 = document.getElementById('player-img1');
	var pimg2 = document.getElementById('player-img2');
	var pimg3 = document.getElementById('player-img3');
	var pimg4 = document.getElementById('player-img4');
	var pimg5 = document.getElementById('player-img5');
	var pimg6 = document.getElementById('player-img6');
	var pimg7 = document.getElementById('player-img7');
	var pimg8 = document.getElementById('player-img8');
	var pimg9 = document.getElementById('player-img9');
	var pimg10 = document.getElementById('player-img10');

	var popup = document.getElementById('overlayChangePlayers');
    var overlay = document.getElementById('backgroundOverlay');
	function list() {
		var listT = '';
		$.ajax ({
				url: 'adHoc',
				type: 'get',
				dataType: 'json',
				data: { 
					player6: document.getElementById('info-player6').innerHTML,
					player7: document.getElementById('info-player7').innerHTML,
					player8: document.getElementById('info-player8').innerHTML,
					player9: document.getElementById('info-player9').innerHTML,
					player10: document.getElementById('info-player10').innerHTML,
				},
				success: function(data){
					let pos = [];
					var iters = data.length
					for (let i=0; i<iters; i++){
						console.log(data[i].Posicion+data[i].Nombre)
						switch(data[i].Posicion) {
							case 'Alero':
								pos.push('F')
								break;
							case 'Pívot':
								pos.push('P')
								break;
							case 'Base':
								pos.push('B')
								break;
						}
						
					}
					document.getElementById('teamLogo1').setAttribute('src',data[0].Escudo);
					document.getElementById('playerPosition1').innerHTML = pos[0];
					document.getElementById('playerName1').innerHTML = data[0].Nombre;
					document.getElementById('playerImg1').setAttribute('src',data[0].Camiseta);
					
					document.getElementById('teamLogo2').setAttribute('src',data[1].Escudo);
					document.getElementById('playerPosition2').innerHTML = pos[1];
					document.getElementById('playerName2').innerHTML = data[1].Nombre;
					document.getElementById('playerImg2').setAttribute('src',data[1].Camiseta);
				},
				error: function(){
					alert("Fallo ajax")
				}
			});
			return listT;
	}
    document.onclick = function(e){
		
        if(e.target.id == 'backgroundOverlay'){
            popup.style.display = 'none';
            overlay.style.display = 'none';
        }
		if(e.target === popup){
         	popup.style.display = 'none';
            overlay.style.display = 'none';
        }
        if(e.target === pimg1){
			list();
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
      	if(e.target === pimg2){
			list();
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
     	 if(e.target === pimg3){
			list();
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
      	if(e.target === pimg4){
			list();
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
      	if(e.target === pimg5){
			list();
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
      	if(e.target === pimg6){
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
        if(e.target === pimg7){
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
      	if(e.target === pimg8){
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
      	if(e.target === pimg9){
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
      	if(e.target === pimg10){
         	popup.style.display = 'block';
            overlay.style.display = 'block';
        }
    };
};


