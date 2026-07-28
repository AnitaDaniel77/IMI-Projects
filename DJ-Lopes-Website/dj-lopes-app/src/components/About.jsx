import aboutImg from '../assets/IMG-20251026-WA0080.jpg'

function About() {
  return (
    <section id="about" className="bg-neutral-900 py-20 px-6">
      <div className="mx-auto max-w-6xl flex flex-col md:flex-row items-center gap-12">

        <div className="w-full md:w-1/2">
          <img
            src={aboutImg}
            alt="DJ Lopes"
            className="rounded-2xl object-cover w-full max-h-[600px]"
          />
        </div>

        <div className="w-full md:w-1/2 text-white">
          <p className="text-sm font-semibold uppercase tracking-[0.3em] text-red-500 mb-4">About</p>
          <h2 className="text-4xl font-extrabold mb-6">The Sound Behind the Movement</h2>
          <p className="text-neutral-300 text-lg leading-relaxed mb-4">
            DJ Lopes is a Mozambican DJ based in Johannesburg, specialising in Afro Latin music — Kizomba, Semba, Salsa, Kompa, Zouk, Tarraxinha, and Passada.
          </p>
          <p className="text-neutral-300 text-lg leading-relaxed mb-4">
            He co-hosts The Afro Latin Social at Arturo Melville on the last Sunday of every month, and at Zor in Dainfern Square on the first and last Thursdays.
          </p>
          <p className="text-neutral-300 text-lg leading-relaxed">
            Whether it's a wedding, year-end function, or social dance event, DJ Lopes brings the energy, the culture, and the music that moves people.
          </p>
          <div className="mt-8">
            <a href="#booking" className="rounded-full bg-red-600 px-8 py-3 font-semibold text-white transition hover:bg-red-700">Book Now</a>
          </div>
        </div>

      </div>
    </section>
  )
}

export default About