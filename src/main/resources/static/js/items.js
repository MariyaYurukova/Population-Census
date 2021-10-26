
$(function() {
    const forms= ["Primary school", "Secondary school","Bachelor degree","Master Degree","Doctorate"];
      $("#education").autocomplete({
        source: forms

    });

});





function addAge() {
    $(function () {
        let $select = $('.selectAge');
        for (i = 1; i <= 111; i++) {
            $select.append($('<option></option>').val(i).html(i))
        }
    });
}
addAge()



//
// const getData = () => {
//   //  fetch('/city/all/{id}').then(function (response) {
//     fetch('/{id}').then(function (response) {
//         return response.text();
//     }).then(function (html) {
//         console.log(html)
//         document.getElementById("detailsCitizen").innerHTML += html;
//     }).catch(function (err) {
//         console.warn('Something went wrong.', err);
//     });
// }






// $('#newPersonForm').submit(function(e) {
//     // will pass the form date using the jQuery serialize function
//     $.post('/addTown', $(this).serialize(), function(response) {
//         $('#personFormResponse').text(response);
//     });
//
//     e.preventDefault(); // prevent actual form submit and page reload
// });








     //
     // $(function () {
     //     function getData() {
     //         let val = document.getElementById('searchCity');
     //         let dataShow = {
     //
     //             name: $("#name").val(), //
     //             citizen: $("#citizens").val()
     //         }; // you can change parameter name
     //
     //         $.ajax({
     //             url: '/all/{id}', // Your Servlet mapping or JSP(not suggested)
     //             data: dataShow,
     //             type: 'GET',
     //             dataType: 'html', // Returns HTML as plain text; included script tags are evaluated when inserted in the DOM.
     //             success: function (response) {
     //                 $('#myPlaceHolder').html(response); // create an empty div in your page with some id
     //             },
     //             error: function (request, textStatus, errorThrown) {
     //                 alert(errorThrown);
     //             }
     //         });
     //     }
     // });

// function getd() {
//     let url = '/city/all/{id}';
//
//     if ($('#selection').val() != '') {
//         url = url + '/' + $('#').val();
//     }
//
//     $("#myPlaceHolder").load("url");
// }
//





// $("#bt1").on("click", function () {
//     $("#content").load("/all/frag1");
// });

// $("#bt1").load("/all/frag1",('#content').serialize());
//$("#selection").load("/all/{id}").('#id').serialize();


// $(function() {
//
//     $('#name').on('change', function() {
//         $("#city").load('/all/name', $("#name").serialize());
//     });
// });

// function retrieveGuests() {
//     let url = '/all/{id}';
//
//     if ($('#searchCity').val() != '') {
//         url = url + '/' + $('#searchCity').val();
//     }
//
//     $("#resultsBlock").load(url);
// }



// function myFunction() {
//     // Get the value of the input field with id="numb"
//     let x = document.getElementById("egn").value;
//     // If x is Not a Number or less than one or greater than 10
//     let text;
//     if (isNaN(x)  || x < 10 || x > 11) {
//         text = "EGN input not valid, because egn has 10numbers";
//     } else {
//         text = "EGN input is OK";
//     }
//     document.getElementById("demo").innerHTML = text;
//
// }







// function attachEvents() {
//     const sendBtn = document.getElementById('submit');
//
//         const headers = {
//             method: 'get',
//             headers: {'Content-type': 'application/html'},
//         }
//         fetch('addTown', headers)
//             .then()
//             .catch(handleErrors);
//
//
// }






// $.ajax({
//     type:"post",
//     data:str,
//     url:"/addTown",
//     dataType: "html",
//     success: function(result){
//         $(element).append(result);
//     }
// });

// function showCustomer(str) {
//     if (str === "") {
//         document.getElementById("txtHint").innerHTML = "";
//         return;
//     }
//     const xhttp = new XMLHttpRequest();
//     xhttp.onload = function() {
//         document.getElementById("txtHint").innerHTML = this.responseText;
//     }
//     xhttp.open("GET", "cit"+str);
//     xhttp.send();
// }



//
// function retrieveGuests() {
//     let url = '/all/{id}';
//
//     if ($('#searchCity').val() != '') {
//         url = url + '/' + $('#searchCity').val();
//     }
//
//     $("#resultsBlock").load(url);
// }
//
//
// const d = new Date();
// document.getElementById("demo").innerHTML = d.getTime();
//
//
//
//
//
// function getCategries(){
//     url="https:localhost....."
//     $.ajax({method: "GET", url})
//         .done(function (responce) {
//             alert(responce)
//         })
//         .fail(function () {
// alert("error")
//         })
//         .always(function () {
//             alert("Always executed")
//
//         })
//     ;
//}

//
// let textDemo=document.getElementById('#textdemo');
// async function loadText(fname) {
//     let str= await fetch(fname)
//     textDemo.innerText=await
//         str.text()
// }
// loadText("details.html")
//
//


// const usersList= document.getElementsByClassName('user-list')
// citizen.map(user => '<li>${user.firstName}</li>')
// .forEach(listItem => usersList.innerHTML += listItem);
//
//
// const usersList= $('.user-list');
// model.forEach(model => $('<li/>')
//     .innerText(model.firstName)
// );


//