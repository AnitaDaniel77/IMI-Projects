import React, { useEffect, useRef } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faGithub, faLinkedin } from "@fortawesome/free-brands-svg-icons";
import { Box, HStack } from "@chakra-ui/react";

const socials = [
  { icon: faGithub, url: "https://github.com/AnitaDaniel77" },
  { icon: faLinkedin, url: "https://www.linkedin.com/in/anita-daniel-2929b513a/" },
];

const Header = () => {
  const headerRef = useRef(null);
  const lastScrollY = useRef(0);

  const handleClick = (anchor) => () => {
    const id = anchor + "-section";
    const element = document.getElementById(id);
    if (element) {
      element.scrollIntoView({ behavior: "smooth", block: "start" });
    }
  };

  // Step 5 — show/hide header based on scroll direction
  useEffect(() => {
    const handleScroll = () => {
      const currentScrollY = window.scrollY;

      if (headerRef.current) {
        if (currentScrollY > lastScrollY.current) {
          // scrolling down — hide header
          headerRef.current.style.transform = "translateY(-200px)";
        } else {
          // scrolling up — show header
          headerRef.current.style.transform = "translateY(0)";
        }
      }

      lastScrollY.current = currentScrollY;
    };

    window.addEventListener("scroll", handleScroll);

    return () => {
      window.removeEventListener("scroll", handleScroll);
    };
  }, []);

  const socialLinks = socials.map(function (social) {
    return (
      <a key={social.url} href={social.url} target="_blank" rel="noopener noreferrer">
        <FontAwesomeIcon icon={social.icon} size="2x" />
      </a>
    );
  });

  return (
    <Box
      ref={headerRef}
      position="fixed"
      top={0}
      left={0}
      right={0}
      transitionProperty="transform"
      transitionDuration=".3s"
      transitionTimingFunction="ease-in-out"
      backgroundColor="#18181b"
    >
      <Box color="white" maxWidth="1280px" margin="0 auto">
        <HStack px={16} py={4} justifyContent="space-between" alignItems="center">
          <nav>
            <HStack spacing={8}>{socialLinks}</HStack>
          </nav>
          <nav>
            <HStack spacing={8}>
              <a href="/#projects" onClick={handleClick("projects")}>Projects</a>
              <a href="/#contactme" onClick={handleClick("contactme")}>Contact Me</a>
            </HStack>
          </nav>
        </HStack>
      </Box>
    </Box>
  );
};

export default Header;