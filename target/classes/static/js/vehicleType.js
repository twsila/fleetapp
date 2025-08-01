// ✅ Utility function to populate edit form fields with vehicleType data
function populateEditForm(data) {
  $('#idEdit').val(data.id);
  $('#descriptionEdit').val(data.description);
  $('#detailsEdit').val(data.details);

  // Delay setting state value to wait for state list to finish loading
  setTimeout(() => {
    $('#stateEdit').val(data.stateid);
  }, 300);
}

// ✅ DOMContentLoaded: Attach edit/delete button behavior
document.addEventListener("DOMContentLoaded", function () {
  // Handle Edit Buttons
  document.querySelectorAll(".editButton").forEach(button => {
    button.addEventListener("click", function (event) {
      event.preventDefault();
      const href = this.getAttribute("href");

      fetch(href)
        .then(response => response.json())
        .then(vehicleType => {
          populateEditForm(vehicleType);
          const editModal = new bootstrap.Modal(document.getElementById("editModal"));
          editModal.show();
        });
    });
  });

  // Handle Delete Buttons
  document.querySelectorAll(".deleteButton").forEach(button => {
    button.addEventListener("click", function (event) {
      event.preventDefault();
      const href = this.getAttribute("href");
      document.getElementById("confirmDeleteRecord").setAttribute("href", href);

      const deleteModal = new bootstrap.Modal(document.getElementById("deleteModal"));
      deleteModal.show();
    });
  });
});