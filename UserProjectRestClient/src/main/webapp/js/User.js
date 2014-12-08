$(document).ready(function(){
    loadContacts();
    
});

function loadContacts(){
    $('#user-list').empty();
    $.ajax({
        url:"http://localhost:8080/UserProjectHibernate/rest/users"
    }).then(function(data, status){
        $.each(data, function(index, user){
            $('#user-list').append('<tr><td>'+ user.id +'</td>' +'<td>' + user.username+'</td>' + '<td>' + user.password + '</td>' + '<td><a onclick="getEditUser(this);" href="#" id="'+user.id+'">Edit</a></td>' + '<td><a onclick="deleteUser(this);" href="#" id="'+user.id+'">Delete</a></td>'+'</tr>');
        });
    });
}

function getEditUser(element){
    $.ajax({
        url: 'http://localhost:8080/UserProjectHibernate/rest/user/' + element.id
    }).success(function(data){
        $('#edit-username').val(data.username);
        $('#edit-password').val(data.password);
    });
}