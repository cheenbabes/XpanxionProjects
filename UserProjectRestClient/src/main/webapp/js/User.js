$(document).ready(function(){
    loadContacts();
    
});

function loadContacts(){
    $('#user-list').empty();
    $.ajax({
        url:"http://localhost:8080/UserProjectHibernate/rest/users"
    }).then(function(data, status){
        $.each(data, function(index, user){
            $('#user-list').append(user.id + ' ' + user.username + ' ' + user.password);
        });
    });
}