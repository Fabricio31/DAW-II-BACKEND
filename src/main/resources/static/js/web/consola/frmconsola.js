$(document).on("click", "#btnagregar", function(){
	$("#txtidconsola").val("");
	$("#txtnomconsola").val("");
	$("#txtdesconsola").val("");
	$.ajax({
		type: "GET",
		url: "/consola/frmconsola",
		dataType: "json"
	})
	$("#modalConsola").modal("show");
});



$(document).on("click", ".btnactualizar", function(){
	$("#txtidconsola").val($(this).attr("data-idconsola"));
	$("#txtnomconsola").val($(this).attr("data-nomconsola"));
	$("#txtdesconsola").val($(this).attr("data-descripcion"));
	//$("#hddidregistrocategoria").val($(this).attr("data-idcategoria"));
	//var idestado = $(this).attr("data-idestado");
	$.ajax({
		type: "GET",
		url: "/consola/frmconsola",
		dataType: "json"
	})
	$("#modalConsola").modal("show");
});




$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/consola/registrarConsola",
		contentType: "application/json",
		data: JSON.stringify({
			id_console : $("#txtidconsola").val(),
			name_console : $("#txtnomconsola").val(),
			description : $("#txtdesconsola").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarSala();
		}
	});
	$("#modalConsola").modal("hide");
})

$(document).on("click", ".btneliminarcategoria", function(){
	$("#hddideliminarsala").val("");
	$("#hddideliminarsala").val($(this).attr("data-idcategoria"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-desccategoria")+"?");
	$("#modalEliminarCategoria").modal("show");
})


$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/consola/eliminarConsola",
		data: JSON.stringify({
			category_id: $("#hddideliminarsala").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarSala();
		}
	})
	$("#modalEliminarConsola").modal("hide");
})


function ListarSala(){
	$.ajax({
		type: "GET",
		url: "/categoria/listarCategorias",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblconsola > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblconsola > tbody").append("<tr>"+
						"<td>"+value.id_console+"</td>"+
						"<td>"+value.name_console+"</td>"+
						"<td>"+value.description+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idcategoria='"+value.id_console+"'"+
							" data-desccategoria='"+value.name_console+"'"+
							" data-desccategoria='"+value.description+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarcategoria'"+	
							" data-idcategoria='"+value.id_console+"'"+
							" data-desccategoria='"+value.name_console+"'"+
							" data-desccategoria='"+value.description+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}








