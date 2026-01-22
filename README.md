Welcome to the Granular Energy Engineering Interview foundation code repository!

# Introduction

This repository contains a foundation that you will build while screensharing with us in the technical interview. Under the repository root there are subfolders for different languages. We want you to work in a language you comfortable in. If your preferred language is not there please let us know ASAP and we will endeavour to create it for you.

# Business context

The core of Granular Energy’s business is allocating electricity production, or generation, to electricity consumption. It is not possible to actually control the flow of electricity from one meter to another, so these allocations happen separately to the actual purchase of energy.

Both the production and consumption of electricity are measured by meters. The information supplied by these meters has a certain granularity or resolution - in other words the size of the time periods into which the energy information is divided.

The granularity could be anything from 1 year down to 1 hour. So for example yearly production information could be that Solar Farm A generated 3000 MWh (megawatt-hours) in 2024 and 3200 MWh in 2025. But for Wind Farm B we might have hourly production information, so for example it generated 350 kWh (kilowatt-hours - 1/1000 of a megawatt-hour) in the first hour of 1st January 2024, 320 kWh in the 2nd hour and so on.

# Preparation for the interview

This repository contains, in multiple languages, a small amount of code that:

- models "consumption volumes" and "production volumes" - these have
  - a starting time
  - a duration (i.e. the granularity described above)
  - a consumer or producer respectively (the entity that consumed or produced some energy in the real world)
  - a quantity of energy in kWh
- has a simple unit test
- implements a command line app to read from CSV files containing consumption and production information. These files are also included

As preparation for the interview please:

1. pick the language you would like to work with. (If you would rather work with another language please let us know.)
2. familiarise yourself with the code
3. run the command line app
4. run the unit tests

Then be ready to screenshare to work on the code.

If anything doesn't work please let us know asap. Or if you can fix it yourself then please do - but this is not a test!

## AI tools

You may use AI tools in the interview, but we need to be able to see your thought process and reasoning with regard to the code you create.

Over-reliance on AI agents will make it harder for us to assess good candidates.  We may ask for tasks to be completed without their use.

# What to expect in the interview

The technical interview will consist of the following

- adding some functionality to the foundation we provide, while screensharing
- further discussion of various technical topics
- a deep dive into a project you have worked on. You are free to use diagramming tools if you like
