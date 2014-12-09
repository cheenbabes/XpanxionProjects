$(document).ready(function () {
    loadContacts();

    //on click for edit button
    $('#editButton').click(function () {
        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/UserProjectHibernate/rest/user/' + $('#edit-id').val(),
            data: JSON.stringify({
                username: $('#edit-username').val(),
                password: $('#edit-password').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#edit-username').val('');
            $('#edit-password').val('');
            loadContacts();
        });
    });

    //code for add button
    $('#addButton').click(function () {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/UserProjectHibernate/rest/user',
            data: JSON.stringify({
                username: $('#add-username').val(),
                password: $('#add-password').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            username: $('#add-username').val('');
            password: $('#add-password').val('');
            loadContacts();
        });
    });
});

function loadContacts() {
    $('#user-list').empty();
    $.ajax({
        url: "http://localhost:8080/UserProjectHibernate/rest/users"
    }).then(function (data, status) {
        $.each(data, function (index, user) {
            $('#user-list').append('<tr><td>' + user.id + '</td>' + '<td>' + user.username + '</td>' + '<td>' + user.password + '</td>' + '<td><a onclick="getEditUser(this);" href="#" id="' + user.id + '">Edit</a></td>' + '<td><a onclick="deleteUser(this);" href="#" id="' + user.id + '">Delete</a></td>' + '</tr>');
        });
    });
}

function getEditUser(element) {
    $.ajax({
        url: 'http://localhost:8080/UserProjectHibernate/rest/user/' + element.id
    }).success(function (data) {
        $('#edit-username').val(data.username);
        $('#edit-password').val(data.password);
        $('#edit-id').val(data.id);
    });
}

function deleteUser(element){
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/UserProjectHibernate/rest/user/' + element.id
    }).success(loadContacts());
    
}