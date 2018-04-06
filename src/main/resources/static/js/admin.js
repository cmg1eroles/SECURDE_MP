$(document).ready(function() {
    console.log("Admin ready!")
    //Get Animals
    $.ajax({
        method: 'GET',
        url: '/posts/adoptions',
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

                $(editbtn).addClass('btn btn-success')
                $(editbtn).attr('data-pid', response[i].id)
                $(editbtn).text('Edit')

                $(deletebtn).addClass('btn btn-danger')
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

                $(statusbtn).addClass('btn btn-success')
                $(statusbtn).attr('data-tid', response[i].id)
                $(statusbtn).text('Change Status')

                $(cancelbtn).addClass('btn btn-danger')
                $(cancelbtn).attr('data-toggle', "modal")
                $(cancelbtn).attr('data-target', "#deletetrans-modal")
                $(cancelbtn).attr('data-tid', response[i].id)
                $(cancelbtn).text('Cancel Transaction')

                $(id).text(response[i].id);
                $(adopter).text(response[i].adopterId);
                $(animal).text(response[i].animalId);
                $(date).text(response[i].dateAdopted);
                $(status).text(response[i].statusCode);
                $(buttons).text();

                $(buttons).append(statusbtn)
                $(buttons).append(cancelbtn)

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
            console.log("Users: ")
            for (var i = 0 ; i < response.length ; i++) {
                console.log(response.length)
                var id = document.createElement('td')
                var username = document.createElement('td')
                var firstname = document.createElement('td')
                var lastname = document.createElement('td')
                var rolecode = document.createElement('td')
                var buttons = document.createElement('td')
                var rolebtn = document.createElement('button')
                var tr = document.createElement('tr')

                $(rolebtn).addClass('btn btn-success')
                $(rolebtn).attr('data-tid', response[i].id)
                $(rolebtn).text('Make Admin')

                $(id).text(response[i].id);
                $(username).text(response[i].username);
                $(firstname).text(response[i].firstName);
                $(lastname).text(response[i].lastName);
                $(rolecode).text(response[i].roleCode);
                $(buttons).text();

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
            console.log("Forum")
            for (var i = 0 ; i < response.length ; i++) {
                console.log("Forum length: " +response.length)
                var id = document.createElement('td')
                var title = document.createElement('td')
                var creator = document.createElement('td')
                var buttons = document.createElement('td')
                var deletebtn = document.createElement('button')
                var tr = document.createElement('tr')

                $(deletebtn).addClass('btn btn-danger')
                $(deletebtn).attr('data-tid', response[i].id)
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
})