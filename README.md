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








