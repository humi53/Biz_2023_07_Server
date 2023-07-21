document.addEventListener("DOMContentLoaded", () => {
  const btn_save = document.querySelector("#btn_save");
  const btn_delete = document.querySelector("#btn_delete");
  const btn_usersave = document.querySelector("#btn_usersave");
  const btn_userdelete = document.querySelector("#btn_userdelete");
  // 책 신규저장
  btn_save?.addEventListener("click", () => {
    document.querySelector("form.main").submit();
  });
  // 책삭제
  btn_delete?.addEventListener("click", () => {
    b_code = document.querySelector("#b_code").value;
    let URL = `${rootPath}book/delete?b_code=` + b_code;
    document.location.href = URL;
  });
  // 유저 신규 저장
  btn_usersave?.addEventListener("click", () => {
    document.querySelector("form.user").submit();
  });
  // 유저 삭제
  btn_userdelete?.addEventListener("click", () => {
    u_code = document.querySelector("#u_code").value;
    let URL = `${rootPath}user/delete?u_code=` + u_code;
    document.location.href = URL;
  });

  // 북 업데이트 화면으로
  const table_book = document.querySelector("table.book");
  const bookTableClickHandler = (e) => {
    const current = e.currentTarget; // table.aim
    const tr = e.target.parentElement;
    const tds = tr.getElementsByTagName("td");
    const l_bcode = tds[0].innerText;
    let URL = `${rootPath}book/update?l_bcode=` + l_bcode;
    document.location.href = URL;
  };
  table_book?.addEventListener("click", bookTableClickHandler);

  // 유져 업데이트 화면을로
  const table_user = document.querySelector("table.user");
  const userTableClickHandler = (e) => {
    const current = e.currentTarget; // table.aim
    const tr = e.target.parentElement;
    const tds = tr.getElementsByTagName("td");
    const l_ucode = tds[0].innerText;
    let URL = `${rootPath}user/update?l_ucode=` + l_ucode;
    document.location.href = URL;
  };
  table_user?.addEventListener("click", userTableClickHandler);
});
