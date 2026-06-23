import { useState } from 'react'
import { FaInstagram, FaFacebookF, FaTiktok, FaBars, FaXmark } from 'react-icons/fa6'
import logo from '../assets/logo-wordmark.png'
const navLinks = [
  { label: 'Home', href: '#home' },
  { label: 'Services', href: '#services' },
  { label: 'About', href: '#about' },
  { label: 'Gallery', href: '#gallery' },
  { label: 'Booking', href: '#booking' },
  { label: 'Contact', href: '#contact' },
]
const socials = [
  { label: 'Instagram', href: 'https://www.instagram.com/d.j.lopes/', Icon: FaInstagram },
  { label: 'Facebook', href: 'https://www.facebook.com/groups/4005691921934/', Icon: FaFacebookF },
  { label: 'TikTok', href: 'https://www.tiktok.com/@d.j.lopes372', Icon: FaTiktok },
]
function Header() {
  const [menuOpen, setMenuOpen] = useState(false)
  return (
    <header className="sticky top-0 z-50 bg-neutral-900/95 backdrop-blur border-b border-neutral-800">
      <div className="mx-auto flex max-w-6xl items-center justify-between px-6 py-4">
        <a href="#home" className="flex items-center"><img src={logo} alt="DJ Lopes" className="h-10 w-auto" /></a>
        <nav className="hidden items-center gap-8 md:flex">
          {navLinks.map((link) => (
            <a key={link.href} href={link.href} className="text-sm font-medium text-neutral-300 transition-colors hover:text-red-500">{link.label}</a>
          ))}
        </nav>
        <div className="flex items-center gap-4">
          <div className="hidden items-center gap-3 md:flex">
            {socials.map(({ label, href, Icon }) => (
              <a key={label} href={href} target="_blank" rel="noopener noreferrer" aria-label={label} className="text-neutral-300 hover:text-red-500"><Icon size={20} /></a>
            ))}
          </div>
          <button type="button" onClick={() => setMenuOpen((open) => !open)} className="text-neutral-200 md:hidden" aria-label="Toggle menu">
            {menuOpen ? <FaXmark size={24} /> : <FaBars size={24} />}
          </button>
        </div>
      </div>
      {menuOpen && (
        <nav className="flex flex-col gap-4 border-t border-neutral-800 px-6 py-4 md:hidden">
          {navLinks.map((link) => (
            <a key={link.href} href={link.href} onClick={() => setMenuOpen(false)} className="text-neutral-300 hover:text-red-500">{link.label}</a>
          ))}
        </nav>
      )}
    </header>
  )
}
export default Header
