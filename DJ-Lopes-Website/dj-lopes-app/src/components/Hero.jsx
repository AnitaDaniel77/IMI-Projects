import heroImg from '../assets/hero.jpg'
function Hero() {
  return (
    <section id="home" className="relative flex min-h-[90vh] items-center justify-center overflow-hidden">
      <img src={heroImg} alt="DJ Lopes performing" className="absolute inset-0 h-full w-full object-cover object-top" />
      <div className="absolute inset-0 bg-gradient-to-b from-black/70 via-black/50 to-neutral-950"></div>
      <div className="relative z-10 mx-auto max-w-3xl px-6 text-center">
        <p className="mb-4 text-sm font-semibold uppercase tracking-[0.3em] text-red-500">Afro Latin DJ and Sound</p>
        <h1 className="text-5xl font-extrabold leading-tight text-white sm:text-6xl md:text-7xl">DJ LOPES</h1>
        <p className="mx-auto mt-6 max-w-xl text-lg text-neutral-200">Kizomba, Semba, Salsa, Kompa, R&B and Old School hip-hop for weddings, parties and year-end functions across Joburg.</p>
        <div className="mt-10 flex flex-col items-center justify-center gap-4 sm:flex-row">
          <a href="#booking" className="rounded-full bg-red-600 px-8 py-3 font-semibold text-white transition hover:bg-red-700">Book DJ Lopes</a>
          <a href="#services" className="rounded-full border border-white/40 px-8 py-3 font-semibold text-white transition hover:bg-white/10">View Services</a>
        </div>
      </div>
    </section>
  )
}
export default Hero
