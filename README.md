# SlicingFlow

## What is Slicing？

This is a data stream processing system with high performance, scalability and massive data processing.

Flexible data flow expansion can be customized as needed to realize enterprise-level data fragmentation, conversion, calculation, verification and other scenarios.

The traditional monitoring system cannot go deep into the details of the business and realize the data check and monitoring alarm of the system's internal data accuracy.

Extensible data processing plug-ins mainly include the following:
- Data source plug-in: The data source is not limited to a fixed data source. The data source can be heterogeneous data sources such as database tables, disk files, and user input.
- Data processing plug-in: The data processing process can be customized as needed, such as data segmentation, data conversion, data calculation, data verification and other scenarios.
- Data summary plug-in: data summary is used for the final data aggregation, storage, alarm and other scenarios.


The work of the data source plug-in is mainly used to collect data. The data flow is as follows: the internal actively pulls the data or passively receives the data sent from the external through RPC interface, MQ, etc. The collected data can be sent to the data processing end after simple processing, and the data can be sent to one or more, depending on the configuration strategy.

The work of the data processing plug-in is mainly to passively receive the data sent by the data source plug-in, and the received data will be processed internally. The specific data processing logic is determined by the current actual plug-in function, which can perform data conversion, data verification and other scenarios. The processed data can continue to be sent to other data processing plug-ins or to the data summary plug-in. The following data processing plug-ins can continue to do the same logic or end directly.  

The data summary plug-in is mainly used to end the data flow. Of course, this plug-in is optional. If you do not need to explicitly use the current plug-in to identify the end of the data flow, you can directly end the data flow in the data processing plug-in.


这是一个高性能，可扩展，海量数据处理的数据流处理系统。

灵活的数据流扩展可以按需定制，用来实现企业级数据分片，转换，计算，核对等场景。

传统的监控系统无法深入业务细节，实现系统内部数据准确性的数据核对监控告警。

可扩展的数据处理插件主要包含如下几种：
- 数据源插件：数据来源不仅仅局限于一个固定的数据源，数据源可以是来自于数据库表，磁盘文件，用户输入等异构数据源头。
- 数据处理插件：数据处理过程可以按需定制比如数据分片，数据转换，数据计算，数据核对等场景。
- 数据汇总插件：数据汇总用于最后的数据聚合，存储，告警等场景。

数据源插件的工作主要是用来收集数据的，数据流转是这样的，内部主动拉取数据或者通过RPC接口、MQ等被动接收外部发送过来的数据，收集到的数据经过简单的处理之后就可以发送到数据处理端，数据可以发送至一个或者多个，这个取决于配置的策略。

数据处理插件的工作主要是被动的接收来自数据源插件发送过来的数据，接收到的数据将会在内部进行处理，具体数据的处理逻辑由当前实际的插件功能决定，可以进行数据转换，数据核对等场景。处理过的数据可以继续发送到其他的数据处理插件中，也可以发送到数据汇总插件中，后面的数据处理插件可以继续做同样的逻辑也可以直接结束。

数据汇总插件的工作主要用于结束数据流转，当然这个插件是可选的，如果不需要明确使用当前插件来标识数据结束流转的可以直接在数据处理插件中将数据流转结束掉。






