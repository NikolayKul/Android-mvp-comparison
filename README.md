# Android MVP comparison

There's a decent amount of different MVP frameworks and libraries for Android. This repo is aimed to help you to choose the one that suits your needs.

TL;DR;

| Library                                           | Support screen rotations | Keep Presenter alive | Can be applied to a custom View | [Dagger](https://github.com/google/dagger) friendly | Kotlin friendly    |
| :-----------------------------------------------: | :----------------------: | :------------------: | :-----------------------------: | :-------------------------------------------------: | :----------------: |
| [EasyMvp](https://github.com/6thsolution/EasyMVP) | :x:                      | :white_check_mark:   | :white_check_mark:              | :white_check_mark:                                  | :white_check_mark: |
| [Moxy](https://github.com/Arello-Mobile/Moxy)     | :white_check_mark:       | :white_check_mark:   | :white_check_mark:              | somewhat                                            | :white_check_mark: |

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

### [EasyMvp](https://github.com/NikolayKul/Android-mvp-comparison/tree/easy_mvp)

:small_blue_diamond: Uses annotation processing  
:small_blue_diamond: The API consists of a few classes and annotations  
:warning: Doesn't restore previous view state after configuration changes  
:warning: There's a [bug](https://github.com/6thsolution/EasyMVP/issues/44) with the latest [Dagger](https://github.com/google/dagger) release   

Furthermore it has a few additional features like [RxApi](http://6thsolution.github.io/EasyMVP/rx-api-javadoc/), but they are not particularly useful.  

### [Moxy](https://github.com/NikolayKul/Android-mvp-comparison/tree/moxy)

:small_blue_diamond: Uses annotation processing  
:small_blue_diamond: Flexible API  
:warning: It's not that easy to [provide a Presenter using Dagger](https://github.com/Arello-Mobile/Moxy/issues/100)

The main feature is a `ViewState`. It's a stack of view commands (e.g. `showLoading`, `showError`) defined in the view interface. Moxy restores the previous view state by applying these commands from the stack depending on [StateStrategies](https://github.com/Arello-Mobile/Moxy/wiki/View-commands-state-strategy) (e.g. it can apply a command every phone rotation or only once)  

## TODO

- [x] [EasyMvp](https://github.com/6thsolution/EasyMVP)
- [x] [Moxy](https://github.com/Arello-Mobile/Moxy)
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
