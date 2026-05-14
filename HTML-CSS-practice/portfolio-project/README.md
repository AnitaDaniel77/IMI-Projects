# Hair Day - Homepage Project

## Project Overview
A homepage built for Hair Day, a boutique hair salon based in Madison, Wisconsin.
Client specialises in edgy colour, on-trend cuts, nails and makeup services.

## HTML Structure Explanation

**DOCTYPE and Head**
The DOCTYPE declaration tells the browser this is an HTML5 document. The head contains the character set, viewport meta tag for responsiveness, the page title and a link to the external stylesheet.

**Header**
Uses the semantic header element to contain the Hair Day logo. Semantic tags help search engines and accessibility software understand the page structure.

**Navigation**
Uses the semantic nav element with an unordered list of four links — Home, Services, About and Book Now. Using a list for navigation is best practice for accessibility and screen readers.

**Main**
Uses the semantic main element to contain all primary page content, split into two sections.

**Banner Section**
The first section contains one article element with a heading, promotional text and a Book Now call to action link. The article element is used because the content is self-contained.

**Three Columns Section**
The second section contains three article elements — one for each service (Cut and Style, Colour Services, Nails and Makeup). Each article has a placeholder image, a heading and descriptive text. Article is used because each column is independent and self-contained content.

**Footer**
Uses the semantic footer element split into two div elements. Div is used instead of article because the footer content should be considered as a whole and is not important for search engines. The left div contains the small HD logo and the right div contains copyright text.

## CSS Explanation

**CSS Reset**
Reset all default browser margins, padding and box sizing for consistent rendering across all browsers.

**Body**
Base font size 1rem, 5% side margins, near black background (#1A1A1A), cream text (#F5EDE3), Georgia serif font for an elegant boutique feel.

**Header**
Logo centred using display block with auto margins. Terracotta bottom border separates header from navigation.

**Navigation**
Bullet points removed, inline-block on list items for horizontal layout. Links in cream with letter spacing. Hover changes to terracotta with 0.3s transition.

**Sections and Articles**
Flexbox on sections for horizontal layout. Each article uses flex: 1 for equal column widths.

**Banner**
First section uses terracotta background for bold promotional banner. Book Now button inverts colours on hover.

**Three Columns**
Images fill container width at fixed height using object-fit: cover. Headings terracotta and uppercase for visual hierarchy.

**Footer**
Two columns using flexbox — logo left, copyright right. Terracotta top border mirrors header for visual consistency.

## Colours
- Primary:    #C4603A (terracotta — from Hair Day logo)
- Background: #1A1A1A (near black)
- Secondary:  #F5EDE3 (cream)

## Layout
- Header: block with auto margins for centring
- Nav:    inline-block horizontal links
- Main:   flexbox sections, equal article columns
- Footer: flexbox two columns

## Semantic Structure
- header  → logo
- nav     → navigation links
- main    → primary page content
- section → content rows
- article → self-contained column content
- footer  → page footer
- div     → non-semantic grouping in footer