$(document).ready(function() {
	$('#userForm').bootstrapValidator({
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
						regexp : /^[a-zA-Z ,.'-]{2,30}$/,
						message : 'Da 2 a 30 caratteri (Solo lettere accettate)'
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
						regexp : /^[0-9]{1,4}$/,
						message : 'Da 1 a 4 cifre (Solo numeri accettati)'
					}
				}
			},
			commenti : {
				container : '#infoCommenti',
				validators : {
					notEmpty : {
						message : 'Il campo commenti non pu&ograve; essere vuoto'
					}, 
					regexp : {
						regexp : /^[a-zA-Z ,.'-]+[0-9]{1,3}$/,
						message : 'scrivi almeno 1 commento'
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
			
			codDocente : {
				container : '#infoCodDocente',
				validators : {
					notEmpty : {
						message : 'Il campo codice docente non pu&ograve; essere vuoto'
					}, 
					regexp : {
						regexp : /^[0-9]{5}$/,
						message : 'inserire 5 cifre per il codice docente'
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

