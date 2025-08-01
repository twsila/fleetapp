
document.addEventListener("DOMContentLoaded", function () {
  const editButtons = document.querySelectorAll(".editButton");

  editButtons.forEach(function (button) {
    button.addEventListener("click", function (event) {
      event.preventDefault();
      const href = this.getAttribute("href");

      fetch(href)
        .then(response => response.json())
        .then(country => {
          document.getElementById("idEdit").value = country.id;
          document.getElementById("descriptionEdit").value = country.description;
          document.getElementById("capitalEdit").value = country.capital; // ✅ Fixed typo
          document.getElementById("codeEdit").value = country.code;
          document.getElementById("nationalityEdit").value = country.nationality;
          document.getElementById("continentEdit").value = country.continent;

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



