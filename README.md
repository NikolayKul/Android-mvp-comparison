# Android MVP comparison

In the world of Android there're a lot of different MVP frameworks and libraries.  
This repo is aimed to help you to choose the right one by __looking at code__.

What do we expect from a perfect MVP library? Here're the most common __requirements__:
- It must handle screen rotations by itself
- It must be easy to setup with a DI library (especially Dagger)
- It must have a flexible API

So... to cut it short:

| Library                                           | Support screen rotations | Dagger friendly | Easy to customize |
| :-----------------------------------------------: | :----------------------: | :-------------: | :---------------: |
| [EasyMvp](https://github.com/6thsolution/EasyMVP) | no                       | yes             | yes               |
| [Moxy](https://github.com/Arello-Mobile/Moxy)     | yes                      | somewhat        | yes               |
| [Mosby](https://github.com/sockeqwe/mosby)        | somewhat                 | yes             | no                |

## Application

Application consists of a single login screen:

<table>
	<tr>
	  <th><img src="img/main.png" width="270" height="480"></th>
	  <th><img src="img/loading.png" width="270" height="480"></th>
	</tr>
	<tr>
	  <th><img src="img/error.png" width="270" height="480"></th>
	  <th><img src="img/success.png" width="270" height="480"></th>
	</tr>
</table>

## Libraries

Every branch represents a single library

>TODO: [Mosby](https://github.com/sockeqwe/mosby)

>TODO: [Moxy](https://github.com/Arello-Mobile/Moxy)

>TODO: [EasyMvp](https://github.com/6thsolution/EasyMVP)

>TODO: Other..

## License

	Copyright 2018 NikolayKul

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	  http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
