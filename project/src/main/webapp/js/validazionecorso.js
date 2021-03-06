$(document).ready(function() {
	$('#corsoForm').bootstrapValidator({
		feedbackIcons: {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh' 
		},
		fields: {
			nome : {
				container : '#infoNome',
				validators : {
					notEmpty : {
						message : 'Il campo nome non pu&ograve; essere vuoto'
					}, 
					regexp : {
						regexp : /^[a-zA-Z0-9]{2,30}$/,
						message : 'Da 2 a 30 caratteri (Solo lettere e numeri accettati)'
					}
				}
			}, 
			costo : {
				container : '#infoCosto',
				validators : {
					notEmpty : {
						message : 'Il campo costo corso non pu&ograve; essere vuoto'
					}, 
					regexp : {
						regexp : /^\d+(.\d+)*$/,
						message : 'inserire numeri con la virgola (carattere accettato per la virgola" .")'
					}
				}
			},
			
			codCorso : {
				container : '#infoCodCorso',
				validators : {
					notEmpty : {
						message : 'Il campo codice corso non pu&ograve; essere vuoto'
					}, 
					regexp : {
						regexp : /^[0-9]{5}$/,
						message : 'inserire 5 cifre per il codice corso'
					}
				}
			}, 
			
			dataInizio : {
				container : '#infoDataInizio',
				validators : {
					notEmpty : {
						message : 'Il campo data inizio non pu&ograve; essere vuoto'
					}, 
					date : {
						format : 'DD/MM/YYYY',
						message : 'Data non valida formato accettato giorno/mese/anno'
					}
				}
			}, 
			
			dataFine : {
				container : '#infoDataFine',
				validators : {
					notEmpty : {
						message : 'Il campo data fine non pu&ograve; essere vuoto'
					}, 
					date : {
						format : 'DD/MM/YYYY',
						message : 'Data non valida formato accettato giorno/mese/anno'
					}
				}
			}, 
			aula : {
				container : '#infoAula',
				validators : {
					notEmpty : {
						message : 'Il campo aula non pu&ograve; essere vuoto'
					}, 
					regexp : {
						regexp : /^[a-zA-Z0-9]{2}$/,
						message : 'Inserire una lettera e un numero'
					}
				}
			}, 
			
		}
	});		
});

