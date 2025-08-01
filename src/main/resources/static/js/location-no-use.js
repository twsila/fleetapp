
document.addEventListener("DOMContentLoaded", function () {
  const editButtons = document.querySelectorAll(".editButton");

  editButtons.forEach(function (button) {
    button.addEventListener("click", function (event) {
      event.preventDefault();
      const href = this.getAttribute("href");

      fetch(href)
        .then(response => response.json())
        .then(location => {
          document.getElementById("idEdit").value 			= location.id;
		  document.getElementById("descriptionEdit").value 	= location.description;
		  document.getElementById("cityEdit").value 		= location.city;
		  document.getElementById("addressEdit").value 		= location.address;
		  document.getElementById("countryEdit").value 		= location.countryid;
		  document.getElementById("stateEdit").value 		= location.stateid;
		  document.getElementById("detailsEdit").value 		= location.details;
          const editModal = new bootstrap.Modal(document.getElementById("editModal"));
          editModal.show();
        });
    });
  });

  const deleteButtons = document.querySelectorAll(".deleteButton");

  deleteButtons.forEach(function (button) {
    button.addEventListener("click", function (event) {
	  event.preventDefault();
	  const href = this.getAttribute("href");
	  document.getElementById("confirmDeleteRecord").setAttribute("href", href);

	  
      const deleteModal = new bootstrap.Modal(document.getElementById("deleteModal"));
      deleteModal.show();
    });
  });
});

/**Fill States Dropdown List Dynamically */
$(document).ready(function () {
    $('#countryid').on('change', function () {
        let countryId = $(this).val();
        $('#stateid').empty().append('<option>-- Loading --</option>');

        if (countryId) {
            $.ajax({
                url: '/stateList',
                type: 'GET',
                data: { countryId: countryId },
                success: function (states) {
                    $('#stateid').empty().append('<option value="">-- Select State --</option>');
                    $.each(states, function (index, state) {
                        $('#stateid').append('<option value="' + state.id + '">' + state.name + '</option>');
                    });
                }
            });
        } else {
            $('#stateid').empty().append('<option value="">-- Select State --</option>');
        }
    });

	//Re-load states when user changes country in modal
	
	$('#countryEdit').on('change', function () {					
	    let countryId = $(this).val();
	    $('#stateEdit').empty().append('<option>-- Loading --</option>');

	    if (countryId) {
	        $.ajax({
	            url: '/stateList',
	            type: 'GET',
	            data: { countryId: countryId },
	            success: function (states) {
	                $('#stateEdit').empty().append('<option value="">-- Select State --</option>');
	                $.each(states, function (index, state) {
	                    $('#stateEdit').append('<option value="' + state.id + '">' + state.name + '</option>');
	                });
	            }
	        });
	    } else {
	        $('#stateEdit').empty().append('<option value="">-- Select State --</option>');
	    }
	});			
});




