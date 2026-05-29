// AUDIO AND VIDEO ASSETS IN REACT
// Three ways to add video to a React app

// METHOD 1: local video using the HTML5 video tag
// import the video file and reference it in src
import myVideo from "./assets/video.mp4";

function LocalVideo() {
  return (
    // controls adds play, pause and volume buttons
    <video src={myVideo} controls width="400" />
  );
}

// METHOD 2: embedded third-party video using an iframe
// pass the video id as a prop so you can swap videos easily
function YoutubeVideo({ videoId }) {
  return (
    <iframe
      src={`https://www.youtube.com/embed/${videoId}`}
      title="Video"
      width="400"
      height="300"
    />
  );
}

// METHOD 3: local audio using the HTML5 audio tag
// same idea as video — import the file and add controls
import myAudio from "./assets/track.mp3";

function AudioPlayer() {
  return (
    <audio src={myAudio} controls />
  );
}

export { LocalVideo, YoutubeVideo, AudioPlayer };