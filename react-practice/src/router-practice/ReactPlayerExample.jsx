// REACT-PLAYER PACKAGE WITH SETTINGS
// One component that plays YouTube, Vimeo, SoundCloud, local files and more

// import the whole package
import ReactPlayer from "react-player";

function ReactPlayerExample() {
  // the video link stored in a variable
  const vidURL = "https://www.youtube.com/watch?v=xxxxx";

  return (
    <div>
      <h1>React Player Example</h1>

      {/* url sets the video link */}
      {/* playing false stops it auto-playing on page load */}
      {/* volume 0.5 starts at half the maximum volume */}
      <ReactPlayer
        url={vidURL}
        playing={false}
        volume={0.5}
        controls
      />
    </div>
  );
}

export default ReactPlayerExample;