// REACT-PLAYER PACKAGE
// One component that plays YouTube, Vimeo, SoundCloud, local files and more

// import the whole package
import ReactPlayer from "react-player";

function ReactPlayerExample() {
  return (
    <div>
      <h1>My Media Player</h1>

      {/* just pass the url — ReactPlayer handles the rest */}
      {/* controls adds the play, pause and volume buttons */}
      <ReactPlayer
        url="https://www.youtube.com/watch?v=xxxxx"
        controls
      />
    </div>
  );
}

export default ReactPlayerExample;