AOS.init({
  duration: 600,
  delay: 200,
});

const swiper = new Swiper(".discount-banner", {
  slidesPerView: 3,
  spaceBetween: 20,
  loop: true,
  navigation: {
    nextEl: ".discount-banner .btn--next",
    prevEl: ".discount-banner .btn--prev",
  },
});

const btnTop = document.querySelector(".btn-top");
btnTop.addEventListener("click", function () {
  window.scrollTo({ top: 0, behavior: "smooth" });
});

const header = document.querySelector(".header");
window.addEventListener("scroll", function (e) {
  if (window.scrollY > 0) {
    header.classList.add("on");
    btnTop.classList.add("on");
  } else {
    header.classList.remove("on");
    btnTop.classList.remove("on");
  }
});

$(".wrap")
  .on("mousemove", magnify)
  .prepend("<div class='magnifier'></div>")
  .children(".magnifier")
  .css({
    background: "url('" + $(".target").attr("src") + "') no-repeat",
  });

var target = $(".target");
var magnifier = $(".magnifier");

/** script3 */
window.onload = function () {
  var target = $(".target");
  var zoom = target.data("zoom");

  $(".wrap")
    .on("mousemove", magnify)
    .prepend("<div class='magnifier'></div>")
    .children(".magnifier")
    .css({
      background: "url('" + target.attr("src") + "') no-repeat",
      // 이미지를 zoom 배율만큼 확대해 배치한다.
      "background-size":
        target.width() * zoom + "px " + target.height() * zoom + "px",
    });

  var magnifier = $(".magnifier");

  function magnify(e) {
    // 마우스 위치에서 .magnify의 위치를 차감해 컨테이너에 대한 마우스 좌표를 얻는다.
    var mouseX = e.pageX - $(this).offset().left;
    var mouseY = e.pageY - $(this).offset().top;

    // 컨테이너 밖으로 마우스가 벗어나면 돋보기를 없앤다.
    if (
      mouseX < $(this).width() &&
      mouseY < $(this).height() &&
      mouseX > 0 &&
      mouseY > 0
    ) {
      magnifier.fadeIn(100);
    } else {
      magnifier.fadeOut(100);
    }

    //돋보기가 존재할 때
    if (magnifier.is(":visible")) {
      // zoom으로 인해 확대된 이미지에 비례한 mouse 좌표를 얻는다.
      var rx = -(mouseX * zoom - magnifier.width() / 2);
      var ry = -(mouseY * zoom - magnifier.height() / 2);

      //돋보기를 마우스 위치에 따라 움직인다.
      //돋보기의 width, height 절반을 마우스 좌표에서 차감해 마우스와 돋보기 위치를 일치시킨다.
      var px = mouseX - magnifier.width() / 2;
      var py = mouseY - magnifier.height() / 2;

      //적용
      magnifier.css({
        left: px,
        top: py,
        backgroundPosition: rx + "px " + ry + "px",
      });
    }
  }
};
