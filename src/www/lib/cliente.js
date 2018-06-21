/**
* Creamos el objeto alumno y todos sus métodos.
*/
$.cliente={};
// Configuración del HOST y URL del servicio
$.cliente.HOST = 'http://localhost:8080';
$.cliente.URL = '/rest/clientes';


$.cliente.ClienteReadREST = function() {
    
    $.ajax({
        url: this.HOST+this.URL,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        success: function (json) {
            $('#r_cliente').empty();
            $('#r_cliente').append('<h3>Listado de Clientes</h3>');
            var table = $('<table />').addClass('table table-stripped');

            table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>nombre</th>', '<th>apellidos</th>', '<th>dni</th>')));
            var tbody = $('<tbody />');
            for (var clave in json) {
                tbody.append($('<tr />').append('<td>' + json[clave].id + '</td>',
                            '<td>' + json[clave].nombre + '</td>', '<td>' + json[clave].apellidos + '</td>', '<td>' + json[clave].dni + '</td>'));
            }
            table.append(tbody);

            $('#r_cliente').append( $('<div />').append(table) );
            $('tr:odd').css('background','#CCCCCC');
        },
        error: function (xhr, status) {
             $.cliente.error('Compruebe su conexión');
        }
    });
};