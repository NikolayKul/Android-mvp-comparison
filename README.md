# Android MVP comparison

In the world of Android there're a lot of different MVP frameworks and libraries.  
This repo is aimed to help you to choose the right one.

What do we expect from a perfect MVP library? Here're the most common __requirements__:
- It must handle screen rotations by itself
- It must be easy to setup with a DI library ([Dagger](https://github.com/google/dagger) especially)
- It must have a flexible API

So... to cut it short:

| Library                                           | Support screen rotations | Dagger friendly    | Easy to customize  |
| :-----------------------------------------------: | :----------------------: | :----------------: | :----------------: |
| [EasyMvp](https://github.com/6thsolution/EasyMVP) | :x:                      | :white_check_mark: | :white_check_mark: |
| [Moxy](https://github.com/Arello-Mobile/Moxy)     | :white_check_mark:       | somewhat           | :white_check_mark: |
| [Mosby](https://github.com/sockeqwe/mosby)        | somewhat                 | :white_check_mark: | :x:                |

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

### [EasyMvp](https://github.com/6thsolution/EasyMVP)

:heavy_plus_sign: Uses annotation processing (less inheritance)  
:heavy_plus_sign: Keeps Presenter alive during configuration changes  
:heavy_plus_sign: There's no entry barrier - a couple of classes and annotations is all you need  
:heavy_minus_sign: Doesn't restore previous view state after configuration changes  

Furthermore it has a few additional features like [RxApi](http://6thsolution.github.io/EasyMVP/rx-api-javadoc/), but they are not particularly useful. Btw there's a [bug](https://github.com/6thsolution/EasyMVP/issues/44) with the latest [Dagger](https://github.com/google/dagger) release.

## TODO

- [x] [EasyMvp](https://github.com/6thsolution/EasyMVP)
- [ ] [Moxy](https://github.com/Arello-Mobile/Moxy)
- [ ] [Mosby](https://github.com/sockeqwe/mosby)
- [ ] Other..

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
