import React from "react";
import { Avatar, Heading, VStack } from "@chakra-ui/react";
import FullScreenSection from "./FullScreenSection";

const greeting = "Hello, I am Anita!";
const bio1 = "An aspiring software engineer";
const bio2 = "specialised in front-end development";

const LandingSection = () => (
  <FullScreenSection
    justifyContent="center"
    alignItems="center"
    isDarkBackground
    backgroundColor="#2A4365"
  >
    <VStack spacing={4}>
      <Avatar size="2xl" src="https://raw.githubusercontent.com/AnitaDaniel77/IMI-Projects/refs/heads/main/mypicture.jpg" />
      <Heading size="xl">{greeting}</Heading>
      <Heading size="lg">{bio1}</Heading>
      <Heading size="lg">{bio2}</Heading>
    </VStack>
  </FullScreenSection>
);

export default LandingSection;