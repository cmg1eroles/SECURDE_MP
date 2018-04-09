$(document).ready(function() {

    var loggedInId = $("#loggedIn").attr("data-uid")

    console.log("Admin ready!")
    //Get Animals
    $.ajax({
        method: 'GET',
        url: '/animal/adoptions',
        contentType: 'application/json',
        success: function(response) {

            for (var i = 0 ; i < response.length ; i++) {
                var id = document.createElement('td')
                var type = document.createElement('td')
                var breed = document.createElement('td')
                var weight = document.createElement('td')
                var picPath = document.createElement('td')
                var vaccines = document.createElement('td')
                var speccond = document.createElement('td')
                var buttons = document.createElement('td')
                var editbtn = document.createElement('button')
                var deletebtn = document.createElement('button')
                var tr = document.createElement('tr')

                $(editbtn).addClass('btn btn-success animalEdit')
                $(editbtn).attr('data-toggle', "modal")
                $(editbtn).attr('data-target', "#animal-modal")
                $(editbtn).attr('data-pid', response[i].id)
                $(editbtn).text('Edit')

                $(deletebtn).addClass('btn btn-danger animalConfirm')
                $(deletebtn).attr('data-toggle', "modal")
                $(deletebtn).attr('data-target', "#delete-modal")
                $(deletebtn).attr('data-pid', response[i].id)
                $(deletebtn).text('Delete')

                $(id).text(response[i].id);
                $(type).text(response[i].animalTypeCode);
                $(breed).text(response[i].breedCode);
                $(weight).text(response[i].weight);
                $(picPath).text(response[i].picPath);
                $(vaccines).text(response[i].vaccines);
                $(speccond).text(response[i].specConds);

                $(buttons).append(editbtn)
                $(buttons).append(deletebtn)

                $(tr).append(id)
                $(tr).append(type)
                $(tr).append(breed)
                $(tr).append(weight)
                $(tr).append(picPath)
                $(tr).append(vaccines)
                $(tr).append(speccond)
                $(tr).append(buttons)

                $('#table_body').append(tr)
            }
        }
    })

    //Get Transactions
    $.ajax({
        method: 'GET',
        url: '/adoptions',
        contentType: 'application/json',
        success: function(response) {

            for (var i = 0 ; i < response.length ; i++) {
                var id = document.createElement('td')
                var adopter = document.createElement('td')
                var animal = document.createElement('td')
                var date = document.createElement('td')
                var status = document.createElement('td')
                var buttons = document.createElement('td')
                var statusbtn = document.createElement('button')
                var cancelbtn = document.createElement('button')
                var tr = document.createElement('tr')

                $(statusbtn).addClass('btn btn-success transEdit')
                $(statusbtn).attr('data-tid', response[i].id)
                $(statusbtn).attr('data-toggle', "modal")
                $(statusbtn).attr('data-target', "#editTrans-modal")
                $(statusbtn).text('Change Status')

                $(id).text(response[i].id);
                $(adopter).text(response[i].adopterId);
                $(animal).text(response[i].animalId);
                $(date).text(response[i].dateAdopted);
                $(status).text(response[i].statusCode);
                $(buttons).text();

                $(buttons).append(statusbtn)

                $(tr).append(id)
                $(tr).append(adopter)
                $(tr).append(animal)
                $(tr).append(date)
                $(tr).append(status)
                $(tr).append(buttons)

                $('#trans-body').append(tr)
            }
        }
    })

    //Get Users
    $.ajax({
        method: 'GET',
        url: '/users',
        contentType: 'application/json',
        success: function(response) {
            for (var i = 0 ; i < response.length ; i++) {
                var id = document.createElement('td')
                var username = document.createElement('td')
                var firstname = document.createElement('td')
                var lastname = document.createElement('td')
                var rolecode = document.createElement('td')
                var buttons = document.createElement('td')
                var rolebtn = document.createElement('button')
                var tr = document.createElement('tr')

                $(rolebtn).addClass('btn btn-success userEdit')
                $(rolebtn).attr('data-uid', response[i].id)
                $(rolebtn).attr('data-toggle', "modal")
                $(rolebtn).attr('data-target', "#editUser-modal")
                $(rolebtn).text('Edit')

                $(id).text(response[i].id);
                $(username).text(response[i].username);
                $(firstname).text(response[i].firstName);
                $(lastname).text(response[i].lastName);
                $(rolecode).text(response[i].roleCode);
                $(buttons).text();

                if (loggedInId != response[i].id)
                    $(buttons).append(rolebtn)

                $(tr).append(id)
                $(tr).append(username)
                $(tr).append(firstname)
                $(tr).append(lastname)
                $(tr).append(rolecode)
                $(tr).append(buttons)

                $('#users-body').append(tr)
            }
        }
    })

    //Get Forums
    $.ajax({
        method: 'GET',
        url: '/forums',
        contentType: 'application/json',
        success: function(response) {
            for (var i = 0 ; i < response.length ; i++) {
                var id = document.createElement('td')
                var title = document.createElement('td')
                var creator = document.createElement('td')
                var buttons = document.createElement('td')
                var deletebtn = document.createElement('button')
                var tr = document.createElement('tr')

                $(deletebtn).addClass('btn btn-danger forumConfirm')
                $(deletebtn).attr('data-fid', response[i].id)
                $(deletebtn).attr('data-toggle', "modal")
                $(deletebtn).attr('data-target', "#deleteforum-modal")
                $(deletebtn).text('Delete Forum')

                $(id).text(response[i].id);
                $(title).text(response[i].title);
                $(creator).text(response[i].firstname);
                $(buttons).text();

                $(buttons).append(deletebtn)

                $(tr).append(id)
                $(tr).append(title)
                $(tr).append(creator)
                $(tr).append(buttons)

                $('#forums-body').append(tr)
            }
        }
    })

    //populate the type drop down
    $.ajax({
        method: 'GET',
        url: '/animal/types',
        contentType: 'application/json',
        success: function(response) {
            for (var i = 0; i < response.length; i++) {
                $("#type_dd").append('<option value=' +response[i].code  + '>' + response[i].animalType + '</option>');
            }
        }
    })

    //populate the breed drop down
    $.ajax({
        method: 'GET',
        url: '/animal/breeds',
        contentType: 'application/json',
        success: function(response) {
            for (var i = 0; i < response.length; i++) {
                $("#breed_dd").append('<option value=' +response[i].code  + '>' + response[i].breed + '</option>');
            }
        }
    })

    //populate the status drop down
    $.ajax({
        method: 'GET',
        url: '/animal/status',
        contentType: 'application/json',
        success: function(response) {
            console.log("status: " +response.length)
            for (var i = 0; i < response.length; i++) {
                $("#status_dd").append('<option value=' +response[i].code  + '>' + response[i].status + '</option>');
                $("#editstatus_dd ").append('<option value=' +response[i].code  + '>' + response[i].status + '</option>');
            }
        }
    })
})