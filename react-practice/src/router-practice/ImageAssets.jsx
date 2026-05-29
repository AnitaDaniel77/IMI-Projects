// THREE WAYS TO DISPLAY IMAGES IN REACT

// METHOD 1: import statement
// import the image and give it a name, then reference that name
import rooftops from "./assets/images/central-park.jpeg";

// a URL for method 3, declared outside the return
const randomImageURL = "https://picsum.photos/200";

function ImageAssets() {
  return (
    <div>

      {/* METHOD 1: use the imported name in the src */}
      <img src={rooftops} height="200" alt="Central Park rooftops" />

      {/* METHOD 2: require the path directly, no import needed */}
      <img
        src={require("./assets/images/central-park.jpeg")}
        height="200"
        alt="Central Park rooftops"
      />

      {/* METHOD 3: load an image hosted on the internet via a URL */}
      <img src={randomImageURL} height="200" alt="A random image from the web" />

    </div>
  );
}

export default ImageAssets;