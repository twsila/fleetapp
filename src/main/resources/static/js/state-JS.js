document.addEventListener("DOMContentLoaded", function () {
  const editButtons = document.querySelectorAll(".editButton");

  editButtons.forEach(function (button) {
    button.addEventListener("click", function (event) {
      event.preventDefault();
      const href = this.getAttribute("href");

      fetch(href)
        .then(response => response.json())
        .then(state => {
          document.getElementById("idEdit").value = state.id;
          document.getElementById("nameEdit").value = state.name;
          document.getElementById("capitalEdit").value = state.capital;
          document.getElementById("countryEdit").value = state.countryid;
          document.getElementById("codeEdit").value = state.code;


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