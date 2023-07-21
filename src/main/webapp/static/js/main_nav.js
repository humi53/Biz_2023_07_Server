document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav.main");

  const navClickHandler = (e) => {
    const current = e.currentTarget; // nav.aim
    const target = e.target; // li

    if (target.tagName === "LI") {
      const targetClassName = target.className;
      const USER_URL = "book user rent";

      if (targetClassName === "home") {
        URL = `${rootPath}`;
      } else if (USER_URL.indexOf(targetClassName) > -1) {
        URL = `${rootPath}` + targetClassName;
      }
      document.location.href = URL;
    }
  };
  nav?.addEventListener("click", navClickHandler);
});
