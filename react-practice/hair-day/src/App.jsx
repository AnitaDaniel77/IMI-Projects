// Import all components from the components folder
import Nav from './components/Nav.jsx'
import Promo from './components/Promo.jsx'
import Intro1 from './components/Intro1.jsx'
import Intro2 from './components/Intro2.jsx'
import Intro3 from './components/Intro3.jsx'
import Footer from './components/Footer.jsx'

// Root component — renders all components together
function App() {
  return (
    <div>
      {/* Navigation menu */}
      <Nav />

      {/* Promotional banner */}
      <Promo />

      {/* Blog post previews */}
      <Intro1 />
      <Intro2 />
      <Intro3 />

      {/* Footer */}
      <Footer />
    </div>
  )
}

export default App