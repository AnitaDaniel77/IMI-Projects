import { Heading, HStack, Image, Text, VStack } from "@chakra-ui/react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRight } from "@fortawesome/free-solid-svg-icons";
import React from "react";

const Card = ({ title, description, imageSrc }) => {
  return (
    <VStack align="start" spacing={3}>
      <Image src={imageSrc} alt={title} borderRadius="md" />
      <Heading size="md">{title}</Heading>
      <Text>{description}</Text>
      <HStack>
        <Text fontWeight="bold">See more</Text>
        <FontAwesomeIcon icon={faArrowRight} size="1x" />
      </HStack>
    </VStack>
  );
};

export default Card;