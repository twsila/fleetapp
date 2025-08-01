<script>
  // ✅ Utility function to dynamically load state options based on selected country
    function loadStates(countrySelector, stateSelector) {}
    const countryId = $(countrySelector).val();
    $(stateSelector).empty().append('<option>-- Loading --</option>');

    if (countryId) {$.ajax({
        url: '/stateList',
        type: 'GET',
        data: { countryId: countryId },
        success: function(states) {
            $(stateSelector).empty().append('<option value="">-- Select State --</option>');
            $.each(states, function(index, state) {
                $(stateSelector).append(`<option value="${state.id}">${state.name}</option>`);
            });
        }
    })};
    } else {$(stateSelector).empty().append('<option value="">-- Select State --</option>')};
    }
  }

    // ✅ Utility function to populate edit form fields with location data
    function populateEditForm(data) {$('#idEdit').val(data.id)};
    $('#descriptionEdit').val(data.description);
    $('#cityEdit').val(data.city);
    $('#addressEdit').val(data.address);
    $('#countryEdit').val(data.countryid).trigger('change'); // trigger state reload
    $('#detailsEdit').val(data.details);

    // Delay setting state value to wait for state list to finish loading
    setTimeout(() => {$('#stateEdit').val(data.stateid)};
    }, 300);
  }

    // ✅ DOMContentLoaded: Attach edit/delete button behavior
    document.addEventListener("DOMContentLoaded", function () {
        // Handle Edit Buttons
        document.querySelectorAll(".editButton").forEach(button => {
            button.addEventListener("click", function(event) {
                event.preventDefault();
                const href = this.getAttribute("href");

                fetch(href)
                    .then(response => response.json())
                    .then(location => {
                        populateEditForm(location);
                        const editModal = new bootstrap.Modal(document.getElementById("editModal"));
                        editModal.show();
                    });
            });
        })};

    // Handle Delete Buttons
    document.querySelectorAll(".deleteButton").forEach(button => {button.addEventListener("click", function(event) {
            event.preventDefault();
            const href = this.getAttribute("href");
            document.getElementById("confirmDeleteRecord").setAttribute("href", href);

            const deleteModal = new bootstrap.Modal(document.getElementById("deleteModal"));
            deleteModal.show();
        })};
    });
  });

    // ✅ On Document Ready (jQuery): Handle country-to-state dropdowns
    $(document).ready(function () {
        // For add/edit form
        $('#countryid').on('change', function() {
            loadStates('#countryid', '#stateid');
        })};

    // For edit modal form
    $('#countryEdit').on('change', function () {loadStates('#countryEdit', '#stateEdit')};
    });
  });
</script>;
